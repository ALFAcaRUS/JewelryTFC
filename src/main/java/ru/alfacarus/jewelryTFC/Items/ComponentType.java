package ru.alfacarus.jewelryTFC.Items;

/**
 *
 */
public enum ComponentType {
    BELT("belts"),
    CHAIN("chains"),
    CLASP("clasps"),
    COULOMB("empty_coulombs"),
    RING("empty_rings"),
    ONE_GEM_CLASP("one_gem_clasps"),
    ONE_GEM_COULOMB("one_gem_coulombs"),
    ONE_GEM_RING("one_gem_rings"),
    THREE_GEM_CLASP("three_gem_clasps"),
    THREE_GEM_COULOMB("three_gem_coulombs");

    private String textureFolder;

    ComponentType(String textureFolder){
        this.textureFolder = textureFolder;
    }

    public String getTextureFolder(){
        return textureFolder;
    }
}
