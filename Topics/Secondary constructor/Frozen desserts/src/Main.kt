class IceCreamOrder {
    var price : Int = 0

    constructor(popsicles : Int){
        this.price = popsicles*7
    }

    constructor(scoops: Int, toppings : Int){
       this.price = 5*scoops + 2*toppings
    }

}
