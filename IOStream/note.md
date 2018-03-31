Programs work with all kinds of data. The data may be stored in files on local
system, in a database, or on a remote computer. Java unifies the data format,
regardless of how they are stored, by using the concept _streams of data_. So,
in the world of Java, all data comes from or goes to streams. Java differentiate
streams by the size of chunks in streams. The streams can be read byte after
byte, character after character, primitive after primitive. Different Java
classes exists for corresponding types of streams.

So with the concept of _streams_, the reading process of Java is as follows:

1. Open a stream that points at a specific data source: file, socket, URL, etc
2. Read/write data from/to the stream
3. Close the stream

## Byte Streams
All byte stream classes are descended from **InputStream** and **OutputStream**.
**FileInputStream** is a byte stream class, which inherits from  **InputStream**.

Byte streams are low-level I/O that we should avoid. In stead, we should use
higher-level I/O like character streams, object streams, etc. But these
higher-level streams build on byte streams.

## Character Streams
All character stream classes are descended from **Reader** and **Writer**. Some
subclasses specialized in reading/writing from certain data sources, such as
**FileReader** and **FileWriter** for files, exist.

Calling these primitive _Reader_/_Writer_ is not efficient since they will give
lots of work to the underlying OS. Accessing disk, internet is usually very
slow. To solve this problem, Buffered Stream comes out of place. Buffered Stream
is a wrapper for these basic streams. Buffered streams utilize these basic
streams while maintain a buffer. The buffered reader will call the underlying
basic reader if the buffer is empty. The buffered writer will call the
underlying basic writer if the buffer is full.

There are four buffered stream classes in total: **BufferedInputStream**,
**BufferedOutputStream** for byte streams, and **BufferedReader**,
**BufferedWriter** for char streams.

## Scanning
Above buffered streams, we can add on another layer, which is **Scanner** and
**Formatter**. These two classes help parse and format given input. Notice that,
**Scanner** is neither subclass nor super class of the stream classes.
**Scanner** simple tokenize its input no matter where it comes from. **Scanner**
can also translates input to its correct form.

## Formatting
Formatting is implemented by two _stream_ objects: **PrintWriter**, inherited
from java.io.Writer, which is a char stream class, and **PrintStream**,
inherited from java.io.OutputStream, which is a byte stream class. Notice that,
**Scanner** is neither super class nor sub class of I/O streams, while
formatters are sub classes of byte stream and char stream. 

Notice that, `System.out` and `System.err` are instances of **PrintStream**. In
our usage, we don't need to instance any other **PrintStream** objects. We only
need to instantiate **PrintWriter** if necessary.

Formatters implement the same set of _write_ methods. Two levels of formatting
are provided:

* `print` and `println` method provides format on individual values in a
  standard way
* `format` methods more control of formatting like in C language.

## I/O from the Command Line -- Standard Streams
Standard input is from the keyboard. Standard output is the screen. Operating
System uses these to operate on files and communicate between programs. The Java
platform provided three corresponding *_streams_*: **System.in** which is an
**InputStream** instance, for standard input. **System.out** which is an
instance of **PrintStream**, a sub class of **OutputStream**, for standard
output. **System.err** which is also an instance of **PrintStream**.

Notice that, all three streams are technically byte streams. But inside
**PrintStream**, something has been done to make it like a character stream.

## I/O from the Command Line -- Console object
Java provided predefined object of type `Console` through calling
`System.console()`. If available, an object will be returned. Otherwise, `NULL`
will be returned. 

The Console is an alternative to the Standard Streams. It provided all features
of standard streams and event more benefits.

## Data Streams
Byte streams and character streams read bytes/chars and store them in an int.
While data streams also read these values, but it can also convert them into
int, double, etc... primitive values, and String values. In byte and character
streams, we read value, and store it in an int. In data stream, we store them in
corresponding type.

Data streams are in fact implementations of two interfaces: **DataInput** and
**DataOutput**. Two most widely-used implementations are **DataInputStream** and
**DataOutputStream**, which are sub classes of InputStream and OutputStream.

## Object Streams
Data streams only work on primitive types and strings. Object streams work on
all kinds of objects of any class, as long as the class implement serialization.
Object streams implement **ObjectInput** and **ObjectOutput** interfaces, which
are sub interfaces of **DataInput** and **DataOutput**.
