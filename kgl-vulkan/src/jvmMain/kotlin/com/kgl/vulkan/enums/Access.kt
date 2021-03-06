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
import org.lwjgl.vulkan.*

actual enum class Access(override val value: Int) : VkFlag<Access> {
	INDIRECT_COMMAND_READ(VK11.VK_ACCESS_INDIRECT_COMMAND_READ_BIT),

	INDEX_READ(VK11.VK_ACCESS_INDEX_READ_BIT),

	VERTEX_ATTRIBUTE_READ(VK11.VK_ACCESS_VERTEX_ATTRIBUTE_READ_BIT),

	UNIFORM_READ(VK11.VK_ACCESS_UNIFORM_READ_BIT),

	INPUT_ATTACHMENT_READ(VK11.VK_ACCESS_INPUT_ATTACHMENT_READ_BIT),

	SHADER_READ(VK11.VK_ACCESS_SHADER_READ_BIT),

	SHADER_WRITE(VK11.VK_ACCESS_SHADER_WRITE_BIT),

	COLOR_ATTACHMENT_READ(VK11.VK_ACCESS_COLOR_ATTACHMENT_READ_BIT),

	COLOR_ATTACHMENT_WRITE(VK11.VK_ACCESS_COLOR_ATTACHMENT_WRITE_BIT),

	DEPTH_STENCIL_ATTACHMENT_READ(VK11.VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_READ_BIT),

	DEPTH_STENCIL_ATTACHMENT_WRITE(VK11.VK_ACCESS_DEPTH_STENCIL_ATTACHMENT_WRITE_BIT),

	TRANSFER_READ(VK11.VK_ACCESS_TRANSFER_READ_BIT),

	TRANSFER_WRITE(VK11.VK_ACCESS_TRANSFER_WRITE_BIT),

	HOST_READ(VK11.VK_ACCESS_HOST_READ_BIT),

	HOST_WRITE(VK11.VK_ACCESS_HOST_WRITE_BIT),

	MEMORY_READ(VK11.VK_ACCESS_MEMORY_READ_BIT),

	MEMORY_WRITE(VK11.VK_ACCESS_MEMORY_WRITE_BIT),

	COMMAND_PROCESS_READ_NVX(NVXDeviceGeneratedCommands.VK_ACCESS_COMMAND_PROCESS_READ_BIT_NVX),

	COMMAND_PROCESS_WRITE_NVX(NVXDeviceGeneratedCommands.VK_ACCESS_COMMAND_PROCESS_WRITE_BIT_NVX),

	COLOR_ATTACHMENT_READ_NONCOHERENT_EXT(EXTBlendOperationAdvanced.VK_ACCESS_COLOR_ATTACHMENT_READ_NONCOHERENT_BIT_EXT),

	CONDITIONAL_RENDERING_READ_EXT(EXTConditionalRendering.VK_ACCESS_CONDITIONAL_RENDERING_READ_BIT_EXT),

	ACCELERATION_STRUCTURE_READ_NV(NVRayTracing.VK_ACCESS_ACCELERATION_STRUCTURE_READ_BIT_NV),

	ACCELERATION_STRUCTURE_WRITE_NV(NVRayTracing.VK_ACCESS_ACCELERATION_STRUCTURE_WRITE_BIT_NV),

	SHADING_RATE_IMAGE_READ_NV(NVShadingRateImage.VK_ACCESS_SHADING_RATE_IMAGE_READ_BIT_NV),

	TRANSFORM_FEEDBACK_WRITE_EXT(EXTTransformFeedback.VK_ACCESS_TRANSFORM_FEEDBACK_WRITE_BIT_EXT),

	TRANSFORM_FEEDBACK_COUNTER_READ_EXT(EXTTransformFeedback.VK_ACCESS_TRANSFORM_FEEDBACK_COUNTER_READ_BIT_EXT),

	TRANSFORM_FEEDBACK_COUNTER_WRITE_EXT(EXTTransformFeedback.VK_ACCESS_TRANSFORM_FEEDBACK_COUNTER_WRITE_BIT_EXT);

	companion object {
		private val enumLookUpMap: Map<Int, Access> = enumValues<Access>().associateBy({
			it.value
		})

		fun fromMultiple(value: Int): VkFlag<Access> = VkFlag(value)

		fun from(value: Int): Access = enumLookUpMap[value]!!
	}
}

