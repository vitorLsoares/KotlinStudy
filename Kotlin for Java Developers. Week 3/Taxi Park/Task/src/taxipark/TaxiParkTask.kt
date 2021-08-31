package taxipark

import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors.toList
import kotlin.math.roundToInt

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
    this.allDrivers.filter { driver -> this.trips.none { it.driver == driver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
    this.allPassengers.filter { passenger -> this.trips.count {it.passengers.contains(passenger)} >= minTrips}.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    this.trips.filter { it.driver == driver }.groupBy { it.passengers }.keys.flatten().sortedBy { it.name }.zipWithNext().filter { it.first == it.second }.flatMap { it.toList() }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
    this.allPassengers.filter{passenger -> this.trips.partition { it.discount != null }
        .let { it.first.count { trip ->  trip.passengers.contains(passenger) } > it.second.count { trip ->  trip.passengers.contains(passenger) } } }
        .toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    return this.trips.associateWith {
        var aux:Int=0
        while(it.duration !in 0+aux..9+aux )
            aux+=10
        0+aux..9+aux
    }.values.groupBy { it }.maxBy { it.value.size }?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {

    if(this.trips.isEmpty()) return false

    val driverToCheck : Int = (this.allDrivers.size * 0.2).roundToInt()
    val allCustTrip: Double = this.trips.sumByDouble { it.cost }
    val sumPrincipalDriver: List<Pair<Driver,Double>> = this.trips.groupBy { it.driver }
        .map { it.key to it.value.sumByDouble { it.cost } }
        .sortedBy { it.second }
        .reversed()
        //.foldIndexed(0.0) {idx, sum , element ->  if(idx <= driverTocheck-1) sum+element else sum  }

    var totalPrinciplaDriver: Double = 0.0
    for (i in 0..sumPrincipalDriver.size){
        if(i <= driverToCheck-1 )
            totalPrinciplaDriver += sumPrincipalDriver[i].second
    }

    return allCustTrip*0.8 <= totalPrinciplaDriver

}