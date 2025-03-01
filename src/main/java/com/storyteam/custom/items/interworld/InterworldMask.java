package com.storyteam.custom.items.interworld;

import com.storyteam.custom.renderer.render.InterworldMaskItemRenderer;
import com.storyteam.custom.renderer.render.InterworldMaskRenderer;
import com.storyteam.custom.renderer.render.JDHArmorRenderer;
import com.storyteam.custom.renderer.render.SpearsRenderer;
import lombok.Getter;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Getter
public class InterworldMask extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final TypeMask typeMask;

    public InterworldMask(ArmorMaterial material, Type type, Settings settings, TypeMask typeMask) {
        super(material, type, settings);
        this.typeMask = typeMask;
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null) this.renderer = new InterworldMaskRenderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }

            private InterworldMaskItemRenderer itemRenderer;

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                if (this.itemRenderer == null) this.itemRenderer = new InterworldMaskItemRenderer();

                return this.itemRenderer;
            }
        });
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
