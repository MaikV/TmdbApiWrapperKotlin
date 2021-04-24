package me.maikv.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TvCertificationValues(
    @SerialName("AU")
    val au: List<Certification>,
    @SerialName("BR")
    val br: List<Certification>,
    @SerialName("CA")
    val ca: List<Certification>,
    @SerialName("CA-QC")
    val caqc: List<Certification>,
    @SerialName("DE")
    val de: List<Certification>,
    @SerialName("ES")
    val es: List<Certification>,
    @SerialName("FR")
    val fr: List<Certification>,
    @SerialName("GB")
    val gb: List<Certification>,
    @SerialName("HU")
    val hu: List<Certification>,
    @SerialName("KR")
    val kr: List<Certification>,
    @SerialName("LT")
    val lt: List<Certification>,
    @SerialName("NL")
    val nl: List<Certification>,
    @SerialName("PH")
    val ph: List<Certification>,
    @SerialName("PT")
    val pt: List<Certification>,
    @SerialName("RU")
    val ru: List<Certification>,
    @SerialName("SK")
    val sk: List<Certification>,
    @SerialName("TH")
    val th: List<Certification>,
    @SerialName("US")
    val us: List<Certification>
)