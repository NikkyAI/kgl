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
package com.kgl.vulkan.handles

import com.kgl.vulkan.dsls.*
import com.kgl.vulkan.enums.*
import com.kgl.vulkan.structs.DescriptorSetLayoutSupport
import com.kgl.vulkan.structs.DeviceGroupPresentCapabilitiesKHR
import com.kgl.vulkan.structs.MemoryFdPropertiesKHR
import com.kgl.vulkan.structs.MemoryHostPointerPropertiesEXT
import com.kgl.vulkan.utils.VkFlag
import com.kgl.vulkan.utils.VkHandle
import kotlinx.io.core.IoBuffer

expect class Device : VkHandle {
	val physicalDevice: PhysicalDevice

	val groupPresentCapabilitiesKHR: DeviceGroupPresentCapabilitiesKHR

	fun getProcAddr(name: String)

	fun getQueue(queueFamilyIndex: UInt, queueIndex: UInt): Queue

	fun waitIdle()

	fun allocateMemory(block: MemoryAllocateInfoBuilder.() -> Unit = {}): DeviceMemory

	fun flushMappedMemoryRanges(block: FlushMappedMemoryRangesBuilder.() -> Unit)

	fun invalidateMappedMemoryRanges(block: InvalidateMappedMemoryRangesBuilder.() -> Unit)

	fun createFence(block: FenceCreateInfoBuilder.() -> Unit = {}): Fence

	fun resetFences(fences: Collection<Fence>)

	fun waitForFences(fences: Collection<Fence>, waitAll: Boolean = true, timeout: ULong = ULong.MAX_VALUE): Boolean

	fun createSemaphore(block: SemaphoreCreateInfoBuilder.() -> Unit = {}): Semaphore

	fun createEvent(block: EventCreateInfoBuilder.() -> Unit = {}): Event

	fun createQueryPool(block: QueryPoolCreateInfoBuilder.() -> Unit = {}): QueryPool

	fun createBuffer(queueFamilyIndices: UIntArray? = null, block: BufferCreateInfoBuilder.() -> Unit = {}): Buffer

	fun createImage(queueFamilyIndices: UIntArray? = null, block: ImageCreateInfoBuilder.() -> Unit): Image

	fun createShaderModule(code: UByteArray, block: ShaderModuleCreateInfoBuilder.() -> Unit = {}): ShaderModule

	fun createPipelineCache(initialData: IoBuffer? = null, block: PipelineCacheCreateInfoBuilder.() -> Unit = {}): PipelineCache

	fun createPipelineLayout(setLayouts: Collection<DescriptorSetLayout>? = null, block: PipelineLayoutCreateInfoBuilder.() -> Unit = {}): PipelineLayout

	fun createGraphicsPipelines(pipelineCache: PipelineCache? = null, block: CreateGraphicsPipelinesBuilder.() -> Unit): List<Pipeline>

	fun createComputePipelines(pipelineCache: PipelineCache? = null, block: CreateComputePipelinesBuilder.() -> Unit): List<Pipeline>

	fun createRayTracingPipelinesNV(pipelineCache: PipelineCache? = null, block: CreateRayTracingPipelinesNVBuilder.() -> Unit): List<Pipeline>

	fun createSampler(block: SamplerCreateInfoBuilder.() -> Unit = {}): Sampler

	fun createDescriptorSetLayout(block: DescriptorSetLayoutCreateInfoBuilder.() -> Unit): DescriptorSetLayout

	fun createDescriptorPool(maxSets: UInt, block: DescriptorPoolCreateInfoBuilder.() -> Unit): DescriptorPool

	fun createRenderPass(block: RenderPassCreateInfoBuilder.() -> Unit): RenderPass

	fun createCommandPool(queueFamilyIndex: UInt, block: CommandPoolCreateInfoBuilder.() -> Unit = {}): CommandPool

	fun createSharedSwapchainsKHR(block: CreateSharedSwapchainsKHRBuilder.() -> Unit): List<SwapchainKHR>

	fun createSwapchainKHR(
			surface: SurfaceKHR,
			queueFamilyIndices: UIntArray? = null,
			oldSwapchain: SwapchainKHR? = null,
			block: SwapchainCreateInfoKHRBuilder.() -> Unit
	): SwapchainKHR

	fun createFramebuffer(renderPass: RenderPass, attachments: Collection<ImageView>?, block: FramebufferCreateInfoBuilder.() -> Unit = {}): Framebuffer

	fun debugMarkerSetObjectNameEXT(block: DebugMarkerObjectNameInfoEXTBuilder.() -> Unit = {})

	fun debugMarkerSetObjectTagEXT(tag: IoBuffer, block: DebugMarkerObjectTagInfoEXTBuilder.() -> Unit = {})

	fun createIndirectCommandsLayoutNVX(block: IndirectCommandsLayoutCreateInfoNVXBuilder.() -> Unit): IndirectCommandsLayoutNVX

	fun createObjectTableNVX(
			objectEntryTypes: Collection<ObjectEntryTypeNVX>,
			objectEntryCounts: UIntArray,
			objectEntryUsageFlags: Collection<VkFlag<ObjectEntryUsageNVX>>,
			block: ObjectTableCreateInfoNVXBuilder.() -> Unit = {}
	): ObjectTableNVX

	fun getMemoryFdPropertiesKHR(handleType: ExternalMemoryHandleType, fd: Int): MemoryFdPropertiesKHR

	fun displayPowerControlEXT(display: DisplayKHR, block: DisplayPowerInfoEXTBuilder.() -> Unit = {})

	fun registerEventEXT(block: DeviceEventInfoEXTBuilder.() -> Unit = {}): Fence

	fun registerDisplayEventEXT(display: DisplayKHR, block: DisplayEventInfoEXTBuilder.() -> Unit = {}): Fence

	fun getGroupPeerMemoryFeatures(heapIndex: UInt, localDeviceIndex: UInt, remoteDeviceIndex: UInt): VkFlag<PeerMemoryFeature>

	fun bindBufferMemory2(block: BindBufferMemory2Builder.() -> Unit)

	fun bindImageMemory2(block: BindImageMemory2Builder.() -> Unit)

	fun getGroupSurfacePresentModesKHR(surface: SurfaceKHR): VkFlag<DeviceGroupPresentModeKHR>

	fun setHdrMetadataEXT(swapchains: Collection<SwapchainKHR>, block: SetHdrMetadataEXTBuilder.() -> Unit)

	fun createSamplerYcbcrConversion(block: SamplerYcbcrConversionCreateInfoBuilder.() -> Unit): SamplerYcbcrConversion

	fun getQueue2(block: DeviceQueueInfo2Builder.() -> Unit = {}): Queue

	fun createValidationCacheEXT(initialData: IoBuffer?, block: ValidationCacheCreateInfoEXTBuilder.() -> Unit = {}): ValidationCacheEXT

	fun getDescriptorSetLayoutSupport(block: DescriptorSetLayoutCreateInfoBuilder.() -> Unit): DescriptorSetLayoutSupport

	fun setDebugUtilsObjectNameEXT(block: DebugUtilsObjectNameInfoEXTBuilder.() -> Unit = {})

	fun setDebugUtilsObjectTagEXT(tag: IoBuffer, block: DebugUtilsObjectTagInfoEXTBuilder.() -> Unit = {})

	fun getMemoryHostPointerPropertiesEXT(handleType: ExternalMemoryHandleType, pHostPointer: IoBuffer): MemoryHostPointerPropertiesEXT

	fun createRenderPass2KHR(correlatedViewMasks: UIntArray, block: RenderPassCreateInfo2KHRBuilder.() -> Unit): RenderPass

	fun createAccelerationStructureNV(block: AccelerationStructureCreateInfoNVBuilder.() -> Unit): AccelerationStructureNV

	fun bindAccelerationStructureMemoryNV(block: BindAccelerationStructureMemoryNVBuilder.() -> Unit)

	fun updateDescriptorSets(block: UpdateDescriptorSetsBuilder.() -> Unit)
}

