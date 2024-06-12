
# 发送消息 给推送服务器


token="dfpmd9f01f1f72dad557f82dde4e884b"
server="https://www.dfpush.com/send/"
package="com.anyone.demo"

message="{\"token\":[\"$token\"],\"package\":\"$package\",\"timeout\":10,\"collapse\":\"abc\",\"data\":{\"from\":\"df\",\"show\":123}}"

# 使用 HTTP 命令行工具 curl 发送消息

curl -k -X POST $server \
-H "Content-Type: application/json;charset=utf-8" \
-d $message
 
