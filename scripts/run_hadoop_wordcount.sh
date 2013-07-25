WORKDIR=$HOME/Developer/olefant

CLASSNAME=com.hadooptraining.counter.WordCount

JVM="-Xmn100M -Xms500M -Xmx500M"
#source $WORKDIR/scripts/setclasspath.sh
echo Deleting old output directory...
hadoop fs -rm -r /user/shrek/output
echo Running Hadoop task...
hadoop jar $WORKDIR/target/olefant-1.0.jar $CLASSNAME input output
echo Here is the output...
hadoop fs -cat /user/shrek/output/part-r-00000
