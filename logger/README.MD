## LOG4J DESIGN

### MAIN CLASS
public class LoggerContext extends ContextBase implements ILoggerFactory, LifeCycle 

public final class Logger implements org.slf4j.Logger, LocationAwareLogger, AppenderAttachable<ILoggingEvent>, Serializable {

### LEVELS IMPLEMENTATION
For Logger Level- It uses Enum as below
    
    LOG LEVELS
    
    public static final int OFF_INT = Integer.MAX_VALUE;
    public static final int ERROR_INT = 40000;
    public static final int WARN_INT = 30000;
    public static final int INFO_INT = 20000;
    public static final int DEBUG_INT = 10000;
    public static final int TRACE_INT = 5000;
    public static final int ALL_INT = Integer.MIN_VALUE;
    
Logging Snipet check levels based on above decleration    
<pre>
private void filterAndLog_0_Or3Plus(final String localFQCN, final Marker marker, final Level level, final String msg, final Object[] params,
                    final Throwable t) {

        final FilterReply decision = loggerContext.getTurboFilterChainDecision_0_3OrMore(marker, this, level, msg, params, t);

        if (decision == FilterReply.NEUTRAL) {
            if (effectiveLevelInt > level.levelInt) {
                return;
            }
        } else if (decision == FilterReply.DENY) {
            return;
        }

        buildLoggingEventAndAppend(localFQCN, marker, level, msg, params, t);
    }
</pre>


### APPENDER
Appnder is responsible for logging, it has various implementation
1. ConsoleAppender
2. AsyncAppender - uses blocking queue
3. DBAppender - Inserts into Database
4. FileAppender - Inserts in File - uses lock mechanism

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
