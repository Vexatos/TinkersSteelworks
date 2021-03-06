package tsteelworks.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import tsteelworks.lib.Repo;
import tsteelworks.lib.TSteelworksRegistry;

public class DustStorageBlock extends BlockSand
{
    public String[] textureNames = new String[] { "gunpowder", "sugar" };
    public Icon[] icons;

    public DustStorageBlock(int id)
    {
        super(id, Material.sand);
        setCreativeTab(TSteelworksRegistry.SteelworksCreativeTab);
        setStepSound(soundSandFootstep);
    }

    @Override
    public int damageDropped (int meta)
    {
        return meta;
    }

    @Override
    public float getBlockHardness (World world, int x, int y, int z)
    {
        return 3f;
    }

    @Override
    public Icon getIcon (int side, int meta)
    {
        return icons[meta];
    }

    @Override
    public void getSubBlocks (int id, CreativeTabs tab, List list)
    {
        for (int iter = 0; iter < 2; iter++)
            list.add(new ItemStack(id, 1, iter));
    }

    @Override
    public int idDropped (int par1, Random par2Random, int par3)
    {
        return blockID;
    }

    @Override
    public void registerIcons (IconRegister iconRegister)
    {
        icons = new Icon[textureNames.length];

        for (int i = 0; i < icons.length; ++i)
            icons[i] = iconRegister.registerIcon(Repo.textureDir + textureNames[i] + "_block");
    }
}
