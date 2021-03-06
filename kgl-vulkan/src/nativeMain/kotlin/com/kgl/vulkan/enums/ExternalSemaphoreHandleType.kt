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

actual enum class ExternalSemaphoreHandleType(override val value: VkExternalSemaphoreHandleTypeFlagBits) : VkFlag<ExternalSemaphoreHandleType> {
	OPAQUE_FD(VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_FD_BIT),

	OPAQUE_WIN32(VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_WIN32_BIT),

	OPAQUE_WIN32_KMT(VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_OPAQUE_WIN32_KMT_BIT),

	D3D12_FENCE(VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_D3D12_FENCE_BIT),

	SYNC_FD(VK_EXTERNAL_SEMAPHORE_HANDLE_TYPE_SYNC_FD_BIT);

	companion object {
		private val enumLookUpMap: Map<UInt, ExternalSemaphoreHandleType> =
				enumValues<ExternalSemaphoreHandleType>().associateBy({ it.value })

		fun fromMultiple(value: VkExternalSemaphoreHandleTypeFlagBits): VkFlag<ExternalSemaphoreHandleType> = VkFlag(value)

		fun from(value: VkExternalSemaphoreHandleTypeFlagBits): ExternalSemaphoreHandleType =
				enumLookUpMap[value]!!
	}
}

