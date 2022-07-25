package uk.netbuilder.go;

import java.awt.*;

public class Tile {
    private Go game;
    private float mX;
    private float mY;
    private int x;
    private int y;
    private int tileID;
    private int posX;
    private int posY;
    private int side = -1;
    private int dims;
    private int size;
    private boolean isPlaced = false;
    private boolean isLabel;
    private boolean isEdge;
    private boolean internalCapture = false;
    private boolean isKo = false;
    private String label;
    private Color color;

    public Tile(Go game, int x, int y, boolean isLabel, String label, int size, int posX, int posY, int dims){
        this.game = game;
        this.x = x;
        this.y = y;
        this.isLabel = isLabel;
        this.label = label;
        this.size = size;
        this.posX = posX;
        this.posY = posY;
        this.dims = dims;
    }

    public void tick(){
        mX = game.getWindow().getMouseListener().getX();
        mY = game.getWindow().getMouseListener().getY();

        if (game.getWindow().getMouseListener().isMouseClicked()) {
            if (contains(mX, mY) && !isLabel) {
                if (game.getGameLogic().getMoveNo() % 2 != 0) {
                    side = 0;
                } else {
                    side = 1;
                }
                if (game.getGameLogic().canPlace(posY, posX, side)) {
                    if (!isPlaced) {
                        isPlaced = true;
                        if (side == 1) {
                            color = Color.black;
                        } else {
                            color = Color.white;
                        }
                        //adjust Go strings
                        game.getGameLogic().checkStrings(posY, posX, side);
                        game.getWindow().getMouseListener().setMouseClicked(false);
                    }
                }else{
                    game.getWindow().getMouseListener().setMouseClicked(false);
                }
            }
            return;
        }
    }

    public void render(Graphics2D g2d){
        g2d.setColor(new Color(190, 130, 101));
        g2d.fillRect(x, y, size, size);
        g2d.setColor(Color.black);

        if(!isLabel) {
            g2d.drawRect(x, y, size -1, size -1);
        }



        if(isLabel){
            g2d.drawString(label, x, y + 10);
        }

//
        if(isPlaced){
            g2d.setColor(color);
            g2d.fillOval(x - (size / 2), y - (size / 2), size , size);
        }


    }




    public boolean isKo() {
        return isKo;
    }

    public void setKo(boolean ko) {
        isKo = ko;
    }

    public boolean isInternalCapture() {
        return internalCapture;
    }

    public void setInternalCapture(boolean internalCapture) {
        this.internalCapture = internalCapture;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }


    public int getTileID() {
        return tileID;
    }

    public void setTileID(int tileID) {
        this.tileID = tileID;
    }

    public boolean isLabel() {
        return isLabel;
    }

    public void setLabel(boolean label) {
        isLabel = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isEdge() {
        return isEdge;
    }

    public void setEdge(boolean edge) {
        isEdge = edge;
    }

    public boolean contains(float mX, float mY) {
        return (mX >= x - size && mY >= y - size && mX <= x + size / 2 && mY <= y + size / 2);
    }
}

