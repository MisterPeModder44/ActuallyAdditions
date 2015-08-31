/*
 * This file ("PageText.java") is part of the Actually Additions Mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://github.com/Ellpeck/ActuallyAdditions/blob/master/README.md
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * � 2015 Ellpeck
 */

package ellpeck.actuallyadditions.booklet.page;

import ellpeck.actuallyadditions.booklet.GuiBooklet;
import ellpeck.actuallyadditions.booklet.InitBooklet;
import net.minecraft.item.ItemStack;

public class PageText extends BookletPage{

    private ItemStack stack;

    public PageText(int id){
        super(id);
    }

    public PageText setStack(ItemStack stack){
        if(!InitBooklet.pagesWithItemStackData.contains(this)){
            InitBooklet.pagesWithItemStackData.add(this);
        }
        this.stack = stack;
        return this;
    }

    @Override
    public ItemStack getItemStackForPage(){
        return this.stack;
    }

    @Override
    public void renderPre(GuiBooklet gui, int mouseX, int mouseY, boolean mouseClick){
        String text = gui.currentPage.getText();
        if(text != null && !text.isEmpty() && !text.contains("booklet.")){
            gui.unicodeRenderer.drawSplitString(text, gui.guiLeft+14, gui.guiTop+11, 115, 0);
        }
    }
}