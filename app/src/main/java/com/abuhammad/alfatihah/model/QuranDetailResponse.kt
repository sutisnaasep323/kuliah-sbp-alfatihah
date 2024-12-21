package com.abuhammad.alfatihah.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class QuranDetailResponse(

	@field:SerializedName("data")
	val data: DataDetail,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("status")
	val status: Int
)

@Keep
data class AsmaDetail(

	@field:SerializedName("ar")
	val ar: Ar,

	@field:SerializedName("translation")
	val translation: TranslationDetail,

	@field:SerializedName("en")
	val en: En,

	@field:SerializedName("id")
	val id: IdDetail
)

@Keep
data class ArDetail(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

@Keep
data class DataDetail(

	@field:SerializedName("number")
	val number: Int,

	@field:SerializedName("sequence")
	val sequence: Int,

	@field:SerializedName("ayahCount")
	val ayahCount: Int,

	@field:SerializedName("tafsir")
	val tafsir: TafsirDetail,

	@field:SerializedName("asma")
	val asma: AsmaDetail,

	@field:SerializedName("ayahs")
	val ayahs: List<AyahsItem>,

	@field:SerializedName("preBismillah")
	val preBismillah: Any,

	@field:SerializedName("type")
	val type: TypeDetail,

	@field:SerializedName("recitation")
	val recitation: RecitationDetail
)

@Keep
data class IdDetail(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

@Keep
data class AyahsItem(

	@field:SerializedName("number")
	val number: Number,

	@field:SerializedName("hizbQuarter")
	val hizbQuarter: Int,

	@field:SerializedName("ruku")
	val ruku: Int,

	@field:SerializedName("translation")
	val translation: TranslationDetail,

	@field:SerializedName("manzil")
	val manzil: Int,

	@field:SerializedName("tafsir")
	val tafsir: TafsirDetail,

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("sajda")
	val sajda: Sajda,

	@field:SerializedName("text")
	val text: Text,

	@field:SerializedName("audio")
	val audio: Audio,

	@field:SerializedName("juz")
	val juz: Int
)

@Keep
data class TafsirDetail(

	@field:SerializedName("en")
	val en: Any,

	@field:SerializedName("id")
	val id: String,

	var isExpandable: Boolean = false
)

@Keep
data class Sajda(

	@field:SerializedName("obligatory")
	val obligatory: Boolean,

	@field:SerializedName("recommended")
	val recommended: Boolean
)

@Keep
data class TranslationDetail(

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String
)

@Keep
data class TypeDetail(

	@field:SerializedName("ar")
	val ar: String,

	@field:SerializedName("en")
	val en: String,

	@field:SerializedName("id")
	val id: String
)

@Keep
data class RecitationDetail(

	@field:SerializedName("full")
	val full: String
)

@Keep
data class Audio(

	@field:SerializedName("url")
	val url: String
)

@Keep
data class EnDetail(

	@field:SerializedName("short")
	val jsonMemberShort: String,

	@field:SerializedName("long")
	val jsonMemberLong: String
)

@Keep
data class TextDetail(

	@field:SerializedName("ar")
	val ar: String,

	@field:SerializedName("read")
	val read: String
)

@Keep
data class Number(

	@field:SerializedName("inquran")
	val inquran: Int,

	@field:SerializedName("insurah")
	val insurah: Int
)
