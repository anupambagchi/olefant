CLASSNAME=com.hadooptraining.fileutil.HDFSJavaAPIDemo

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

JVM="-Xmn100M -Xms500M -Xmx500M"
echo Deleting old file...
hadoop fs -rm demo.txt
echo Running Hadoop file creation task...
hadoop jar $SCRIPTPATH/../target/olefant-1.0.jar $CLASSNAME hdfs://localhost:9000
echo Here is the output...
hadoop fs -cat demo.txt