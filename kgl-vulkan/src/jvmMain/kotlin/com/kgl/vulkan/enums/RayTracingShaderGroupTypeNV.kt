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
import org.lwjgl.vulkan.NVRayTracing

actual enum class RayTracingShaderGroupTypeNV(override val value: Int) : VkEnum<RayTracingShaderGroupTypeNV> {
	GENERAL(NVRayTracing.VK_RAY_TRACING_SHADER_GROUP_TYPE_GENERAL_NV),

	TRIANGLES_HIT_GROUP(NVRayTracing.VK_RAY_TRACING_SHADER_GROUP_TYPE_TRIANGLES_HIT_GROUP_NV),

	PROCEDURAL_HIT_GROUP(NVRayTracing.VK_RAY_TRACING_SHADER_GROUP_TYPE_PROCEDURAL_HIT_GROUP_NV);

	companion object {
		fun from(value: Int): RayTracingShaderGroupTypeNV =
				enumValues<RayTracingShaderGroupTypeNV>()[value]
	}
}

