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

expect enum class ExternalMemoryHandleType : VkFlag<ExternalMemoryHandleType> {
	OPAQUE_FD,

	OPAQUE_WIN32,

	OPAQUE_WIN32_KMT,

	D3D11_TEXTURE,

	D3D11_TEXTURE_KMT,

	D3D12_HEAP,

	D3D12_RESOURCE,

	HOST_ALLOCATION_EXT,

	HOST_MAPPED_FOREIGN_MEMORY_EXT,

	DMA_BUF_EXT,

	// ANDROID_HARDWARE_BUFFER_ANDROID
}

