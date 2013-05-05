WORKDIR=$HOME/Developer/olefant

CLASSNAME=com.agilesoft.fileutil.HDFSJavaAPIDemo

JVM="-Xmn100M -Xms500M -Xmx500M"
echo Deleting old file...
hadoop fs -rm /user/anupam/demo.txt
echo Running Hadoop file creation task...
hadoop jar $WORKDIR/target/olefant-1.0.jar $CLASSNAME hdfs://localhost:9000
echo Here is the output...
hadoop fs -cat /user/anupam/demo.txt