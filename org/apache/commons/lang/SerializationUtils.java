package org.apache.commons.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/* compiled from: TbsSdkJava */
public class SerializationUtils {
    public static Object clone(Serializable serializable) {
        return deserialize(serialize(serializable));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Throwable e;
        if (outputStream == null) {
            throw new IllegalArgumentException("The OutputStream must not be null");
        }
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new SerializationException(e);
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e5) {
            e = e5;
            objectOutputStream = null;
            throw new SerializationException(e);
        } catch (Throwable th2) {
            e = th2;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw e;
        }
    }

    public static byte[] serialize(Serializable serializable) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Object deserialize(InputStream inputStream) {
        Throwable e;
        if (inputStream == null) {
            throw new IllegalArgumentException("The InputStream must not be null");
        }
        ObjectInputStream objectInputStream = null;
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(inputStream);
            try {
                Object readObject = objectInputStream2.readObject();
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e2) {
                    }
                }
                return readObject;
            } catch (ClassNotFoundException e3) {
                e = e3;
                try {
                    throw new SerializationException(e);
                } catch (Throwable th) {
                    e = th;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                objectInputStream = objectInputStream2;
                try {
                    throw new SerializationException(e);
                } catch (Throwable th2) {
                    e = th2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
        } catch (ClassNotFoundException e6) {
            e = e6;
            objectInputStream2 = null;
            throw new SerializationException(e);
        } catch (IOException e7) {
            e = e7;
            throw new SerializationException(e);
        }
    }

    public static Object deserialize(byte[] bArr) {
        if (bArr != null) {
            return deserialize(new ByteArrayInputStream(bArr));
        }
        throw new IllegalArgumentException("The byte[] must not be null");
    }
}
