package lila.simul
package actorApi

import lila.socket.SocketMember
import lila.user.User

private[simul] case class Member(
  channel: JsChannel,
  userId: Option[String],
  troll: Boolean) extends SocketMember

private[simul] object Member {
  def apply(channel: JsChannel, user: Option[User]): Member = Member(
    channel = channel,
    userId = user map (_.id),
    troll = user.??(_.troll))
}

private[simul] case class Messadata(trollish: Boolean = false)

private[simul] case class Join(
  uid: String,
  user: Option[User],
  version: Int)
private[simul] case class Talk(tourId: String, u: String, t: String, troll: Boolean)
private[simul] case class StartGame(game: lila.game.Game)
private[simul] case object Reload
private[simul] case class Connected(enumerator: JsEnumerator, member: Member)

private[simul] case object NotifyCrowd
private[simul] case object NotifyReload
