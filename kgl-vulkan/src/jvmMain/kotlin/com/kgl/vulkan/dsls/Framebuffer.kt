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

import com.kgl.vulkan.handles.ImageView
import com.kgl.vulkan.handles.RenderPass
import com.kgl.vulkan.utils.toVkType
import org.lwjgl.vulkan.VK11
import org.lwjgl.vulkan.VkFramebufferCreateInfo

actual class FramebufferCreateInfoBuilder(internal val target: VkFramebufferCreateInfo) {
	actual var width: UInt
		get() = target.width().toUInt()
		set(value) {
			target.width(value.toVkType())
		}

	actual var height: UInt
		get() = target.height().toUInt()
		set(value) {
			target.height(value.toVkType())
		}

	actual var layers: UInt
		get() = target.layers().toUInt()
		set(value) {
			target.layers(value.toVkType())
		}

	internal fun init(renderPass: RenderPass, attachments: Collection<ImageView>?) {
		target.sType(VK11.VK_STRUCTURE_TYPE_FRAMEBUFFER_CREATE_INFO)
		target.pNext(0)
		target.flags(0)
		target.renderPass(renderPass.toVkType())
		target.pAttachments(attachments?.toVkType())
	}
}

