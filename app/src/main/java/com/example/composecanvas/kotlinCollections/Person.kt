data class Person(
    val name: String,
    val age: Int
)

data class Address(
    val id: String,
    val lines: List<AddressLines>
)

data class AddressLines(
    val line1:String,
    val line2:String
)

object Lists {
    val groupOfPerson = listOf(
        Person("Bharat", 22), Person("Luffy", 30),
        Person("Zoro", 50), Person("Shanks", 44),
        Person("Big Mom", 6),  Person("Garp", 80)
    )

    val addresses = listOf(
        Address("1", listOf(AddressLines("kolkata","howrah"))),
        Address("2", listOf(AddressLines("london","st street"))),
        Address("3", listOf(AddressLines("Delhi","Jai Nagar"))),
        Address("4", listOf(AddressLines("Totto Land","Whole Cake Island"))),
    )

}

fun main() {
    val list = Lists.groupOfPerson
    val addresses = Lists.addresses

   val newList =  list.filter {person->
      person.age>18
    }



    val addressLines = addresses.flatMap {
      it.lines
    }

    print(newList)
}
