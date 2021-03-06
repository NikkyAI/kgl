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
package com.kgl.vulkan.structs

import com.kgl.vulkan.enums.CompositeAlphaKHR
import com.kgl.vulkan.enums.ImageUsage
import com.kgl.vulkan.enums.SurfaceCounterEXT
import com.kgl.vulkan.enums.SurfaceTransformKHR
import org.lwjgl.vulkan.VkSurfaceCapabilities2EXT

fun SurfaceCapabilities2EXT.Companion.from(ptr: VkSurfaceCapabilities2EXT): SurfaceCapabilities2EXT = SurfaceCapabilities2EXT(
		ptr.minImageCount().toUInt(),
		ptr.maxImageCount().toUInt(),
		Extent2D.from(ptr.currentExtent()),
		Extent2D.from(ptr.minImageExtent()),
		Extent2D.from(ptr.maxImageExtent()),
		ptr.maxImageArrayLayers().toUInt(),
		SurfaceTransformKHR.fromMultiple(ptr.supportedTransforms()),
		SurfaceTransformKHR.from(ptr.currentTransform()),
		CompositeAlphaKHR.fromMultiple(ptr.supportedCompositeAlpha()),
		ImageUsage.fromMultiple(ptr.supportedUsageFlags()),
		SurfaceCounterEXT.fromMultiple(ptr.supportedSurfaceCounters())
)
