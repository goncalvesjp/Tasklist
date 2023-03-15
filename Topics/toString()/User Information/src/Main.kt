class CustomerInfo(
    /** Unique user id */
    val uid: String,
    /** Operation system: Windows, Linux, macOS, iOS */
    val operationSystem: String,
    /** In GB */
    val ram: Int,
    /** In GHz */
    val coreSpeed: Double,
    val timeStamp: Long
) {

    override fun toString(): String {
        return "Id: $uid; Operation System: $operationSystem; RAM: ${ram.toString()}; Core Speed: ${coreSpeed.toString()}; Timestamp: ${timeStamp.toString()}"
    }
}
fun sendCustomerInfoToServer(customer: CustomerInfo) {
    Server.send(customer.toString())
}