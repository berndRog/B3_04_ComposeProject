package de.rogallab.android.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Person(
   // fields
   var id: UUID = UUID.randomUUID(),
   var name:  String? = "",
   var email: String? = "",
   var street:String? = "",
   var city:  String? = ""
)  : Parcelable {

   fun asString(): String = "$name $email $street $city"


   constructor(parcel: Parcel) : this(
      UUID.fromString(parcel.readString()),
      parcel.readString(),
      parcel.readString(),
      parcel.readString(),
      parcel.readString()
   )


   override fun writeToParcel(parcel: Parcel, flags: Int) {
      parcel.writeString(id.toString())
      parcel.writeString(name)
      parcel.writeString(email)
      parcel.writeString(street)
      parcel.writeString(city)
   }

   override fun describeContents(): Int {
      return 0
   }

   companion object CREATOR : Parcelable.Creator<Person> {
      override fun createFromParcel(parcel: Parcel): Person {
         return Person(parcel)
      }

      override fun newArray(size: Int): Array<Person?> {
         return arrayOfNulls(size)
      }
   }

}