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
package com.kgl.vulkan.enums

import com.kgl.vulkan.utils.VkFlag
import org.lwjgl.vulkan.EXTDebugUtils

actual enum class DebugUtilsMessageSeverityEXT(override val value: Int) : VkFlag<DebugUtilsMessageSeverityEXT> {
	VERBOSE(EXTDebugUtils.VK_DEBUG_UTILS_MESSAGE_SEVERITY_VERBOSE_BIT_EXT),

	INFO(EXTDebugUtils.VK_DEBUG_UTILS_MESSAGE_SEVERITY_INFO_BIT_EXT),

	WARNING(EXTDebugUtils.VK_DEBUG_UTILS_MESSAGE_SEVERITY_WARNING_BIT_EXT),

	ERROR(EXTDebugUtils.VK_DEBUG_UTILS_MESSAGE_SEVERITY_ERROR_BIT_EXT);

	companion object {
		private val enumLookUpMap: Map<Int, DebugUtilsMessageSeverityEXT> =
				enumValues<DebugUtilsMessageSeverityEXT>().associateBy({ it.value })

		fun fromMultiple(value: Int): VkFlag<DebugUtilsMessageSeverityEXT> = VkFlag(value)

		fun from(value: Int): DebugUtilsMessageSeverityEXT = enumLookUpMap[value]!!
	}
}

