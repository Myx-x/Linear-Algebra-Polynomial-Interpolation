
import florencia.augmentedmatrix.AugmentedMatrix;
import florencia.matrix.*;


public class Main
{
    public static void main(String args[])
    {
       AugmentedMatrix aug = new AugmentedMatrix();
       aug = aug.makeInterpolationMatrix();
       aug.convertToInterpolation(aug);
    }
}