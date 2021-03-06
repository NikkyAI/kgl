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
import cvulkan.VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT
import cvulkan.VK_IMAGE_TILING_LINEAR
import cvulkan.VK_IMAGE_TILING_OPTIMAL
import cvulkan.VkImageTiling

actual enum class ImageTiling(override val value: VkImageTiling) : VkEnum<ImageTiling> {
	OPTIMAL(VK_IMAGE_TILING_OPTIMAL),

	DRM_FORMAT_MODIFIER_EXT(VK_IMAGE_TILING_DRM_FORMAT_MODIFIER_EXT),

	LINEAR(VK_IMAGE_TILING_LINEAR);

	companion object {
		private val enumLookUpMap: Map<UInt, ImageTiling> = enumValues<ImageTiling>().associateBy({
			it.value
		})

		fun from(value: VkImageTiling): ImageTiling = enumLookUpMap[value]!!
	}
}

