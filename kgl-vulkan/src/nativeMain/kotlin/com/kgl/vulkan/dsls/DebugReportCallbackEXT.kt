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
package com.kgl.vulkan.dsls

import com.kgl.vulkan.enums.DebugReportEXT
import com.kgl.vulkan.enums.DebugReportObjectTypeEXT
import com.kgl.vulkan.utils.VkFlag
import cvulkan.VK_FALSE
import cvulkan.VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
import cvulkan.VkDebugReportCallbackCreateInfoEXT
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.asStableRef
import kotlinx.cinterop.staticCFunction
import kotlinx.cinterop.toKString


actual class DebugReportCallbackCreateInfoEXTBuilder(internal val target: VkDebugReportCallbackCreateInfoEXT) {
	internal fun init(flags: VkFlag<DebugReportEXT>, callback: (VkFlag<DebugReportEXT>, DebugReportObjectTypeEXT, ULong, ULong, Int, String, String) -> Unit) {
		target.sType = VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT
		target.pNext = null
		target.flags = flags.value

		target.pUserData = StableRef.create(callback).asCPointer()
		target.pfnCallback = staticCFunction { flags, objectType, `object`, location, messageCode, pLayerPrefix, pMessage, pUserData ->
			val callback = pUserData!!.asStableRef<(VkFlag<DebugReportEXT>, DebugReportObjectTypeEXT, ULong, ULong, Int, String, String) -> Unit>().get()

			callback(
					DebugReportEXT.fromMultiple(flags),
					DebugReportObjectTypeEXT.from(objectType),
					`object`.toULong(), location.toULong(), messageCode,
					pLayerPrefix!!.toKString(),
					pMessage!!.toKString()
			)
			VK_FALSE.toUInt()
		}
	}
}

