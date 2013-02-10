greeCocos2d
===========
File Name : setup.sh
-----------------------
#!/bin/sh

URL="http://cocos2d-x.googlecode.com/files/"
TARGET="cocos2d-2.0-x-2.0.4"
TARGETFILE=${TARGET}".zip"
LOCALFILE="cocos2dx.zip"


echo ${URL}${TARGETFILE}


if [ ! -e ${LOCALFILE} ]; then
        echo "Download cocos2dx source code"
        curl -o ${LOCALFILE} ${URL}${TARGETFILE}
        #wget ${URL}${TARGETFILE} -O ${LOCALFILE}
fi
if [ ! -d ${TARGET} ]; then
        echo "Unzip cocos2dx"
        unzip ${LOCALFILE}
fi

rsync -a --delete ${EXTENSIONDIR} ${TARGET}
rsync -a --delete ${EXTENSIONJAVADIR} ${JAVADIR}
rsync -a --delete ${PATCHDIR}/GreeBasicSample ${TARGET}/samples/
rsync -a ${PATCHDIR}/template/xcode4 ${TARGET}/template/

echo "Apply patch for gree_extension"
patch -d ${TARGET} -p0 < Cocos2dxHelper.java.patch

echo "Finish Setup"


File Name : Cocos2dxHelper.java.patch
--------------------------------------
--- cocos2dx/platform/android/java/src/org/cocos2dx/lib/Cocos2dxHelper.java.org 2012-11-06 20:14:03.854890121 +0900
+++ cocos2dx/platform/android/java/src/org/cocos2dx/lib/Cocos2dxHelper.java     2012-11-06 20:14:25.542970652 +0900
@@ -26,6 +26,8 @@
 import java.io.UnsupportedEncodingException;
 import java.util.Locale;

+import org.cocos2dx.lib.gree.Cocos2dxGreePlatform;
+
 import android.content.Context;
 import android.content.pm.ApplicationInfo;
 import android.content.res.AssetManager;
@@ -68,6 +70,8 @@
                Cocos2dxHelper.sCocos2dSound = new Cocos2dxSound(pContext);
                Cocos2dxHelper.sAssetManager = pContext.getAssets();
                Cocos2dxBitmap.setContext(pContext);
+
+               Cocos2dxGreePlatform.init(pContext);
        }

// ===========================================================
~                                                                                                                                                                                                
~                                                                                 

~                                                                                                                                                                                                
~                                                                     
