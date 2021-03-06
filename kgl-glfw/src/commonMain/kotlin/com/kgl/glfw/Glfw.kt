/**
 * Copyright [2019] [Dominic Fischer]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kgl.glfw

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
expect object Glfw {
	var time: Double
	val timerValue: ULong
	val timerFrequency: ULong

	var currentContext: Window?
	val primaryMonitor: Monitor?
	val monitors: List<Monitor>

	fun init(): Boolean
	fun terminate()

	fun setErrorCallback(callback: ((Int, String) -> Unit)? = null)
	fun setJoystickCallback(callback: (Joystick, Boolean) -> Unit)
	fun setMonitorCallback(callback: (Monitor, Boolean) -> Unit)
}

expect fun pollEvents()
expect fun waitEvents()
expect fun waitEvents(timeout: Double)
expect fun postEmptyEvent()
expect fun setSwapInterval(interval: Int)
