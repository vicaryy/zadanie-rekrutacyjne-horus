package org.vicary;

import java.util.*;

public class WallStack implements Structure {
    private final List<Block> blocks;

    public WallStack(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (blocks == null || color == null)
            return Optional.empty();

        Stack<Block> stack = new Stack<>();
        stack.addAll(blocks.reversed());

        while (stack.iterator().hasNext()) {
            Block block = stack.pop();
            if (block.color() != null && block.color().equals(color))
                return Optional.of(block);
            if (block instanceof CompositeBlock compositeBlock)
                stack.addAll(compositeBlock.blocks().reversed());
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (blocks == null || material == null)
            return Collections.emptyList();

        List<Block> foundBlocks = new ArrayList<>();
        Stack<Block> stack = new Stack<>();
        stack.addAll(blocks.reversed());

        while (stack.iterator().hasNext()) {
            Block block = stack.pop();
            if (block.material() != null && block.material().equals(material))
                foundBlocks.add(block);
            if (block instanceof CompositeBlock compositeBlock)
                stack.addAll(compositeBlock.blocks().reversed());
        }
        return foundBlocks;
    }

    @Override
    public int count() {
        int amount = 0;
        if (blocks == null)
            return amount;

        Stack<Block> stack = new Stack<>();
        stack.addAll(blocks.reversed());

        while (stack.iterator().hasNext()) {
            Block block = stack.pop();
            amount++;
            if (block instanceof CompositeBlock compositeBlock)
                stack.addAll(compositeBlock.blocks().reversed());
        }
        return amount;
    }
}
