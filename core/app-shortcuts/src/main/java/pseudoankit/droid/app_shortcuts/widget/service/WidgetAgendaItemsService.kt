package pseudoankit.droid.app_shortcuts.widget.service

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent.inject
import pseudoankit.droid.agendamanger.domain.model.AgendaItem
import pseudoankit.droid.agendamanger.domain.repository.AgendaRepository
import pseudoankit.droid.app_shortcuts.R
import pseudoankit.droid.app_shortcuts.widget.util.displayDateTime
import pseudoankit.droid.core.coroutine.launch
import pseudoankit.droid.core.util.extension.orZero


class WidgetAgendaItemsService : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return AgendaItemsRemoteViewsFactory(applicationContext)
    }

    internal class AgendaItemsRemoteViewsFactory(
        private val context: Context
    ) : RemoteViewsFactory {
        private val agendaRepository: AgendaRepository by inject(AgendaRepository::class.java)
        private var agendaItems: List<AgendaItem>? = listOf()
        private var job: Job? = null

        override fun onCreate() {
            job = launch {
                agendaRepository
                    .getAllSavedItem()
                    .onEach {
                        agendaItems = it
                    }
                    .launchIn(this)
            }
        }

        override fun onDataSetChanged() {

        }

        override fun onDestroy() {
            job?.cancel()
            job = null
            agendaItems = null
        }

        override fun getCount(): Int {
            return agendaItems?.size.orZero
        }

        override fun getViewAt(position: Int): RemoteViews {
            val item = agendaItems?.getOrNull(position)
            val remoteView = RemoteViews(context.packageName, R.layout.widget_agenda_item_view)
            remoteView.setTextViewText(R.id.title, item?.title.orEmpty())
            remoteView.setTextViewText(R.id.dateTime, item?.displayDateTime.orEmpty())
            return remoteView
        }

        override fun getLoadingView(): RemoteViews {
            return RemoteViews(context.packageName, R.layout.widget_agenda_item_loading)
        }

        override fun getViewTypeCount(): Int {
            return 1
        }

        override fun getItemId(position: Int): Long {
            return agendaItems?.getOrNull(position)?.id ?: 0L
        }

        override fun hasStableIds(): Boolean {
            return true
        }
    }
}