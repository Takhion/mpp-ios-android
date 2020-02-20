import SwiftUI
import core

struct ContentView: View {
    var body: some View {
        Text(CommonKt.createApplicationScreenMessage())
            .font(.largeTitle)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
