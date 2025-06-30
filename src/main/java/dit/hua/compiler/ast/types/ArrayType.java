package dit.hua.compiler.ast.types;

import java.util.ArrayList;
import java.util.List;




//Class that represents array types int[10], char[5],..
//Matches the prpduction: type :: = int_lit_list

public class ArrayType extends Type {

    private Type elementType;
    private List<Integer> dimensions;

    public ArrayType (Type elementType, List<Integer> dimensions){
        super();
        this.elementType = elementType;
        this.dimensions = dimensions;
    }

    public ArrayType(Type elementType){
        this(elementType, new ArrayList<>());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ArrayType)) return false;
        ArrayType otherArray = (ArrayType) other;
        return elementType.equals(otherArray.elementType) &&
            dimensions.equals(otherArray.dimensions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(elementType.toString());
        for (Integer dimension : dimensions){
            sb.append("[").append(dimension).append("]");
        }
        return sb.toString();
    }

    @Override
    public boolean isCompatible(Type other) {
        if (!(other instanceof ArrayType)) return false;
        ArrayType otherArray = (ArrayType) other;
        return elementType.isCompatible(otherArray.elementType) && 
               dimensions.equals(otherArray.dimensions);
    }


    public Type getElementType() {
        return elementType;
    }

    public void setElementType(Type elementType) {
        this.elementType = elementType;
    }

    public List<Integer> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<Integer> dimensions) {
        this.dimensions = dimensions;
    }
}
