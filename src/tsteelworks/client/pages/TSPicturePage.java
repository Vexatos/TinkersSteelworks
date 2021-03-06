package tsteelworks.client.pages;

import net.minecraft.util.ResourceLocation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TSPicturePage extends TSBookPage
{
    String text;
    String location;

    ResourceLocation background;

    @Override
    public void readPageFromXML (Element element)
    {
        NodeList nodes = element.getElementsByTagName("text");
        if (nodes != null)
            text = nodes.item(0).getTextContent();

        nodes = element.getElementsByTagName("location");
        if (nodes != null)
            location = nodes.item(0).getTextContent();

        background = new ResourceLocation(location);
    }

    @Override
    public void renderBackgroundLayer (int localWidth, int localHeight)
    {
        manual.getMC().getTextureManager().bindTexture(background);
        //manual.getMC().renderEngine.bindTexture(location);
        manual.drawTexturedModalRect(localWidth, localHeight + 12, 0, 0, 170, 144);
    }

    @Override
    public void renderContentLayer (int localWidth, int localHeight)
    {
        manual.fonts.drawSplitString(text, localWidth + 8, localHeight, 178, 0);
    }
}
