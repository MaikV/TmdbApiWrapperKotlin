package me.maikv.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieCertificationValues(
    @SerialName("AU")
    val au: List<Certification>,
    @SerialName("BG")
    val bg: List<Certification>,
    @SerialName("BR")
    val br: List<Certification>,
    @SerialName("CA")
    val ca: List<Certification>,
    @SerialName("CA-QC")
    val caqc: List<Certification>,
    @SerialName("DE")
    val de: List<Certification>,
    @SerialName("DK")
    val dk: List<Certification>,
    @SerialName("ES")
    val es: List<Certification>,
    @SerialName("FI")
    val fi: List<Certification>,
    @SerialName("FR")
    val fr: List<Certification>,
    @SerialName("GB")
    val gb: List<Certification>,
    @SerialName("HU")
    val hu: List<Certification>,
    @Suppress("ConstructorParameterNaming")
    @SerialName("IN")
    val `in`: List<Certification>,
    @SerialName("IT")
    val it: List<Certification>,
    @SerialName("LT")
    val lt: List<Certification>,
    @SerialName("MY")
    val mY: List<Certification>,
    @SerialName("NL")
    val nl: List<Certification>,
    @SerialName("NO")
    val no: List<Certification>,
    @SerialName("NZ")
    val nz: List<Certification>,
    @SerialName("PH")
    val ph: List<Certification>,
    @SerialName("PT")
    val pt: List<Certification>,
    @SerialName("RU")
    val ru: List<Certification>,
    @SerialName("SE")
    val se: List<Certification>,
    @SerialName("US")
    val us: List<Certification>
)