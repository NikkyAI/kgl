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

import com.kgl.vulkan.utils.VkEnum
import cvulkan.*

actual enum class PhysicalDeviceType(override val value: VkPhysicalDeviceType) : VkEnum<PhysicalDeviceType> {
	OTHER(VK_PHYSICAL_DEVICE_TYPE_OTHER),

	INTEGRATED_GPU(VK_PHYSICAL_DEVICE_TYPE_INTEGRATED_GPU),

	DISCRETE_GPU(VK_PHYSICAL_DEVICE_TYPE_DISCRETE_GPU),

	VIRTUAL_GPU(VK_PHYSICAL_DEVICE_TYPE_VIRTUAL_GPU),

	CPU(VK_PHYSICAL_DEVICE_TYPE_CPU);

	companion object {
		fun from(value: VkPhysicalDeviceType): PhysicalDeviceType =
				enumValues<PhysicalDeviceType>()[value.toInt()]
	}
}

