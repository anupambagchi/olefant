WORKDIR=$HOME/Developer/olefant

CLASSNAME=com.agilesoft.loganalyzer.genericwritable.LogProcessor

JVM="-Xmn100M -Xms500M -Xmx500M"
echo Deleting old file...
hadoop fs -rm -r /user/anupam/output
echo Running Hadoop file creation task...
hadoop jar $WORKDIR/target/olefant-1.0.jar $CLASSNAME input output 2
echo Here is the output...
hadoop fs -cat /user/anupam/output/part-r-00000