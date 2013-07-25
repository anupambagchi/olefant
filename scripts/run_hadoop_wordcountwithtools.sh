CLASSNAME=com.hadooptraining.counter.WordCountWithTools

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

JVM="-Xmn100M -Xms500M -Xmx500M"
echo Deleting old output directory...
hadoop fs -rm -r /data/output
hadoop jar $SCRIPTPATH/../target/olefant-1.0.jar $CLASSNAME
echo Running Hadoop task...
hadoop jar $SCRIPTPATH/../target/olefant-1.0.jar $CLASSNAME /data/input /data/output
echo Here is the output...
hadoop fs -cat /data/output/part-r-00000
echo