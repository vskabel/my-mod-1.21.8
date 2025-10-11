package com.abel.mymod.item;

import com.abel.mymod.MyMod;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModFoodComponents {
    public static final FoodWithEffects CAULIFLOWER = createFoodWithEffects(3, 0.25f,
            new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 0));
    /**
     * Helper function to create a FoodComponent with nutrition and saturation.
     *
     * @param nutrition The nutrition value (hunger bars restored)
     * @param saturation The saturation modifier
     * @return A built FoodComponent
     */
    public static FoodComponent createFood(int nutrition, float saturation) {
        return new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build();
    }

    /**
     * Helper function to create a ConsumableComponent with potion effects.
     * Use this with DataComponentTypes.CONSUMABLE when registering items.
     *
     * @param effects Variable number of StatusEffectInstance objects to apply when eaten
     * @return A built ConsumableComponent
     */
    public static ConsumableComponent createConsumableWithEffects(StatusEffectInstance... effects) {
        ConsumableComponent.Builder builder = ConsumableComponent.builder();

        for (StatusEffectInstance effect : effects) {
            builder.consumeEffect(new ApplyEffectsConsumeEffect(effect, 1.0f));
        }

        return builder.build();
    }

    /**
     * Container class to hold both FoodComponent and ConsumableComponent.
     */
    public static class FoodWithEffects {
        public final FoodComponent food;
        public final ConsumableComponent consumable;

        public FoodWithEffects(FoodComponent food, ConsumableComponent consumable) {
            this.food = food;
            this.consumable = consumable;
        }
    }

    /**
     * Helper function to create both FoodComponent and ConsumableComponent with effects.
     *
     * @param nutrition The nutrition value (hunger bars restored)
     * @param saturation The saturation modifier
     * @param effects Variable number of StatusEffectInstance objects to apply when eaten
     * @return A FoodWithEffects containing both components
     */
    public static FoodWithEffects createFoodWithEffects(int nutrition, float saturation, StatusEffectInstance... effects) {
        FoodComponent food = createFood(nutrition, saturation);
        ConsumableComponent consumable = createConsumableWithEffects(effects);
        return new FoodWithEffects(food, consumable);
    }

    /**
     * Helper function to register a food item with FoodWithEffects.
     *
     * @param name The item name/id
     * @param foodWithEffects The FoodWithEffects containing food and consumable components
     * @return Item.Settings configured with the food components
     */
    public static Item.Settings createFoodItemSettings(String name, FoodWithEffects foodWithEffects) {
        return new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MyMod.MOD_ID, name)))
                .component(DataComponentTypes.FOOD, foodWithEffects.food)
                .component(DataComponentTypes.CONSUMABLE, foodWithEffects.consumable);
    }
}
