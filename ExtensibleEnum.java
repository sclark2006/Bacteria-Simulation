
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
//import java.util.Map;

/**
 * Gene class is a personal implementation of an enum, but it allows to create 
 * new instances that are not in the original list of constants
 * 
 * @author Frederick Clark 
 * @version May 8, 2012
 */
public abstract class ExtensibleEnum<E extends ExtensibleEnum<E>>
{
    private static LinkedHashMap<String,Object> GENES_DICTIONARY = new LinkedHashMap<String,Object>();
    private static int nextOrdinal = 0;
    // instance variables - replace the example below with your own
    private final String _name;
    private final int _ordinal;
    
    /**
     * Constructor for objects of class Gene2
     */
    protected ExtensibleEnum(String name, int ordinal)
    {
        this._name = name;
        this._ordinal = ordinal;
    }
    
    public final String name() {
        return _name;
    }
    
    public final int ordinal() {
        return this._ordinal;
    }
    
    @Override
    public final int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public final boolean equals(Object other) {
        return this==other;
    }
    
    @Override
    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    
    @Override
    public String toString() {
        return this._name;
    }
        
    public static  <T extends ExtensibleEnum<T>> T valueOf(Class<T> enumType, String name) {       
        @SuppressWarnings("unchecked")
		T result = (T) GENES_DICTIONARY.get(name);
        if (result != null)
            return result;
        if (name == null)
            throw new NullPointerException("Name is null");
        throw new IllegalArgumentException(
            "No enum constant " + enumType.getCanonicalName() + "." + name);
    }
        
    public static <T extends ExtensibleEnum<T>> T [] values() {
        @SuppressWarnings("unchecked")
		final T[] extEnums = (T[])GENES_DICTIONARY.values().toArray();
        return extEnums;
    }
    
    public static <T extends ExtensibleEnum<T>> T newInstance(Class<T> enumType, String name) 
            throws IllegalArgumentException {

        try {
            Constructor<T> ctor = enumType.getConstructor(String.class, int.class);
            T extEnum = (T)ctor.newInstance(name, nextOrdinal);
            GENES_DICTIONARY.put(name, extEnum);
            nextOrdinal++;
            return extEnum;
        }
        //catch(NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        catch(Exception e) {
        	e.printStackTrace();
        throw new IllegalArgumentException("The class "+enumType.getSimpleName() + " doesn't inherits " + ExtensibleEnum.class.getSimpleName());
        } 

    }
    


}
