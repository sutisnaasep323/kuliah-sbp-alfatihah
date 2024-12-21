package com.abuhammad.alfatihah.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
 data class QuranResponse(

	@field:SerializedName("data")
	val data: List<Data>,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

@Keep
 data class Type(

	@field:SerializedName("ar")
	val ar: String,

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String
)

@Keep
 data class Data(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("sequence")
	val sequence: Int,

	@field:SerializedName("ayahCount")
	val ayahCount: Int,

	@field:SerializedName("tafsir")
	val tafsir: Tafsir,

	@field:SerializedName("asma")
	val asma: Asma,

	@field:SerializedName("preBismillah")
	val preBismillah: Any,

	@field:SerializedName("type")
	val type: Type,

	@field:SerializedName("recitation")
	val recitation: Recitation
)

@Keep
 data class Ar(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

@Keep
 data class Translation(

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String
)

@Keep
 data class Recitation(

	@field:SerializedName("full")
	val full: String
)

@Keep
 data class En(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

@Keep
 data class Tafsir(

	@field:SerializedName("en")
	val en: Any,

	@field:SerializedName("id")
	val id: String
)

@Keep
 data class Text(

	@field:SerializedName("ar")
	val ar: String,

	@field:SerializedName("read")
	val read: String
)

@Keep
 data class PreBismillah(

	@field:SerializedName("translation")
	val translation: Translation,

	@field:SerializedName("text")
	val text: Text
)

@Keep
 data class Id(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

@Keep
 data class Asma(

	@field:SerializedName("ar")
	val ar: Ar,

	@field:SerializedName("translation")
	val translation: Translation,

	@field:SerializedName("en")
	val en: En,

	@field:SerializedName("id")
	val id: Id
)
