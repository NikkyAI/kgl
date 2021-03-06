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
import cvulkan.*

actual enum class ImageUsage(override val value: VkImageUsageFlagBits) : VkFlag<ImageUsage> {
	TRANSFER_SRC(VK_IMAGE_USAGE_TRANSFER_SRC_BIT),

	TRANSFER_DST(VK_IMAGE_USAGE_TRANSFER_DST_BIT),

	SAMPLED(VK_IMAGE_USAGE_SAMPLED_BIT),

	STORAGE(VK_IMAGE_USAGE_STORAGE_BIT),

	COLOR_ATTACHMENT(VK_IMAGE_USAGE_COLOR_ATTACHMENT_BIT),

	DEPTH_STENCIL_ATTACHMENT(VK_IMAGE_USAGE_DEPTH_STENCIL_ATTACHMENT_BIT),

	TRANSIENT_ATTACHMENT(VK_IMAGE_USAGE_TRANSIENT_ATTACHMENT_BIT),

	INPUT_ATTACHMENT(VK_IMAGE_USAGE_INPUT_ATTACHMENT_BIT),

	SHADING_RATE_IMAGE_NV(VK_IMAGE_USAGE_SHADING_RATE_IMAGE_BIT_NV);

	companion object {
		private val enumLookUpMap: Map<UInt, ImageUsage> = enumValues<ImageUsage>().associateBy({
			it.value
		})

		fun fromMultiple(value: VkImageUsageFlagBits): VkFlag<ImageUsage> = VkFlag(value)

		fun from(value: VkImageUsageFlagBits): ImageUsage = enumLookUpMap[value]!!
	}
}

