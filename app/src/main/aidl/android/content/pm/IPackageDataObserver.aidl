// IPackageDataObserver.aidl
package android.content.pm;

oneway interface IPackageDataObserver{
    void onRemoveCompleted(in String packageName,boolean succeeded);
}
// Declare any non-default types here with import statements

//interface IPackageDataObserver {
//    /**
//     * Demonstrates some basic types that you can use as parameters
//     * and return values in AIDL.
//     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
//}
