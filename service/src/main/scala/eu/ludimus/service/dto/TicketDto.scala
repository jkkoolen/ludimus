package eu.ludimus.service.dto

import java.math.BigDecimal
import java.util.Date

import eu.ludimus.service.dto.validation.CheckImage
import org.springframework.format.annotation.DateTimeFormat

import scala.beans.BeanProperty

@CheckImage
class TicketDto {
  @BeanProperty
  var id: Long = -1
  @BeanProperty
  var lastUpdated: Date = null
  @BeanProperty
  var created: Date = null
  @BeanProperty
  @DateTimeFormat(pattern = "dd-MM-yyyy") var ticketDate: Date = null
  @BeanProperty
  var invoiceNumber: String = null
  @BeanProperty
  var description: String = null
  @BeanProperty
  var price: BigDecimal = null
  @BeanProperty
  var vatRate: BigDecimal = null
  @BeanProperty
  var ticketImage: Array[Byte] = null
  @BeanProperty
  var income: Boolean = false
  @BeanProperty
  var user: UserDto = new UserDto
  @BeanProperty
  var forMonth: Integer = null
}
