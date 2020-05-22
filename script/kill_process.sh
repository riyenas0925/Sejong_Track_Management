pid="$(lsof -t -i :8080 -s TCP:LISTEN)";
if [ "$pid" != "" ]; then
  kill -9 $pid;
  echo "$pid process kill complete"
else
  echo "pid is empty"
fi