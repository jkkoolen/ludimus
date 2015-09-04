package eu.ludimus.service.dto

import java.util.Date

import eu.ludimus.domain.entity.User.Role

import scala.beans.BeanProperty

class UserDto {
  @BeanProperty
  var id: Long = -1
  @BeanProperty
  var lastUpdated: Date = null
  @BeanProperty
  var created: Date = null
  @BeanProperty
  var name: String = null
  @BeanProperty
  var password: String = null
  @BeanProperty
  var active: Boolean = false
  @BeanProperty
  var role: Role = null
  @BeanProperty
  var resetToken: String = null
}
