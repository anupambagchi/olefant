CLASSNAME=com.hadooptraining.counter.WordCount

pushd `dirname $0` > /dev/null
SCRIPTPATH=`pwd -P`
popd > /dev/null

JVM="-Xmn100M -Xms500M -Xmx500M"
#source $WORKDIR/scripts/setclasspath.sh
echo Deleting old output directory...
hadoop fs -rm -r /user/shrek/output
echo Running Hadoop task...
hadoop jar $SCRIPTPATH/../target/olefant-1.0.jar $CLASSNAME input output
echo Here is the output...
hadoop fs -cat /user/shrek/output/part-r-00000
