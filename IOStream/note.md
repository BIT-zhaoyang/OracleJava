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

Above buffered streams, we can add on another layer, which is **Scanner** and
**Formatter**. These two classes help parse and format given input. Notice that,
**Scanner** is neither subclass nor super class of the stream classes.
**Scanner** simple tokenize its input no matter where it comes from. **Scanner**
can also translates input to its correct form.
