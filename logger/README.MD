## LOG4J DESIGN

### APPENDER
Appnder is responsible for logging, it has various implementation
1. ConsoleAppender
2. AsyncAppender - uses blocking queue
3. DBAppender - Inserts into Database
4. FileAppender - Inserts in File - uses lock mechanism

For Logger Level- It uses Enum as below


Below is Base Appender Functionality

<pre>
public interface Appender<E> extends LifeCycle, ContextAware, FilterAttachable<E> {

    /**
     * Get the name of this appender. The name uniquely identifies the appender.
     */
    String getName();

    /**
     * This is where an appender accomplishes its work. Note that the argument 
     * is of type Object.
     * @param event
     */
    void doAppend(E event) throws LogbackException;

    /**
     * Set the name of this appender. The name is used by other components to
     * identify this appender.
     * 
     */
    void setName(String name);

}
</pre>
